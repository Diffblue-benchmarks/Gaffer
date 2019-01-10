/*
 * Copyright 2018 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.rest.service.v2;

import org.junit.Test;

import uk.gov.gchq.gaffer.jobtracker.Job;
import uk.gov.gchq.gaffer.jobtracker.JobDetail;
import uk.gov.gchq.gaffer.jobtracker.JobStatus;
import uk.gov.gchq.gaffer.jobtracker.Repeat;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.operation.impl.job.CancelScheduledJob;
import uk.gov.gchq.gaffer.operation.impl.job.GetAllJobDetails;
import uk.gov.gchq.gaffer.rest.ServiceConstants;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JobServiceV2IT extends AbstractRestApiV2IT {

    @Test
    public void shouldCorrectlyDoAndThenCancelScheduledJob() throws IOException, InterruptedException {
        // When
        final Repeat repeat = new Repeat(1, 2, TimeUnit.SECONDS);
        Job job = new Job(repeat, new OperationChain.Builder().first(new GetAllElements()).build());
        final Response jobSchedulingResponse = client.scheduleJob(job);

        JobDetail jobSchedulingDetail = jobSchedulingResponse.readEntity(new GenericType<JobDetail>() {
        });

        // Then
        assertEquals(201, jobSchedulingResponse.getStatus());
        String parentJobId = jobSchedulingDetail.getJobId();

        // Wait for first scheduled to run
        Thread.sleep(1500);

        final Response getAllJobDetailsResponse = client.executeOperation(new GetAllJobDetails());

        List<JobDetail> jobDetails = getAllJobDetailsResponse.readEntity(new GenericType<List<JobDetail>>() {
        });

        for (JobDetail jobDetail : jobDetails) {
            if (null != jobDetail.getParentJobId() && jobDetail.getParentJobId().equals(parentJobId)) {
                assertEquals(JobStatus.FINISHED, jobDetail.getStatus());
            }
            if (jobDetail.getJobId().equals(parentJobId)) {
                assertEquals(JobStatus.SCHEDULED_PARENT, jobDetail.getStatus());
            }
        }

        client.executeOperation(new CancelScheduledJob.Builder().jobId(parentJobId).build());

        final Response getAllJobDetailsResponseAfterCancelled = client.executeOperation(new GetAllJobDetails());

        List<JobDetail> jobDetailsAfterCancelled = getAllJobDetailsResponseAfterCancelled.readEntity(new GenericType<List<JobDetail>>() {
        });

        for (JobDetail jobDetail : jobDetailsAfterCancelled) {
            if (parentJobId.equals(jobDetail.getJobId())) {
                assertEquals(JobStatus.CANCELLED, jobDetail.getStatus());
            }
        }
    }

    @Test
    public void shouldReturnJobIdHeader() throws IOException {
        // When
        final Response response = client.executeOperation(new GetAllElements());

        // Then
        assertNotNull(response.getHeaderString(ServiceConstants.JOB_ID_HEADER));
    }
}