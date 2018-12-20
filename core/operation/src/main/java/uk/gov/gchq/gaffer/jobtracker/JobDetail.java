/*
 * Copyright 2016-2018 Crown Copyright
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
package uk.gov.gchq.gaffer.jobtracker;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import uk.gov.gchq.gaffer.commonutil.CommonConstants;
import uk.gov.gchq.gaffer.commonutil.ToStringBuilder;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.jsonserialisation.JSONSerialiser;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationChainDAO;

import java.io.Serializable;
import java.nio.charset.Charset;

/**
 * POJO containing details of a Gaffer job.
 */
public class JobDetail implements Serializable {
    private static final long serialVersionUID = -1677432285205724269L;
    private static final String CHARSET_NAME = CommonConstants.UTF_8;
    private String parentJobId;
    private String jobId;
    private String userId;
    private JobStatus status;
    private Long startTime;
    private Long endTime;
    private String opChain;
    private String description;

    public JobDetail() {
    }

    public JobDetail(final JobDetail oldJobDetail, final JobDetail newJobDetail) {
        this.jobId = getNewOrOld(oldJobDetail.jobId, newJobDetail.jobId);
        this.userId = getNewOrOld(oldJobDetail.userId, newJobDetail.userId);
        this.opChain = getNewOrOld(oldJobDetail.opChain, newJobDetail.opChain);
        this.description = getNewOrOld(oldJobDetail.description, newJobDetail.description);
        this.status = getNewOrOld(oldJobDetail.status, newJobDetail.status);
        this.parentJobId = getNewOrOld(oldJobDetail.parentJobId, newJobDetail.parentJobId);

        if (null == oldJobDetail.startTime) {
            this.startTime = System.currentTimeMillis();
        } else {
            this.startTime = oldJobDetail.startTime;
            this.endTime = System.currentTimeMillis();
        }
    }

    public JobDetail(final String jobId, final String userId, final OperationChain<?> opChain, final JobStatus jobStatus, final String description) {
        try {
            if (opChain instanceof OperationChainDAO) {
                this.opChain = new String(JSONSerialiser.serialise(opChain), Charset.forName(CHARSET_NAME));
            } else {
                final OperationChainDAO dao = new OperationChainDAO(opChain.getOperations());
                this.opChain = new String(JSONSerialiser.serialise(dao), Charset.forName(CHARSET_NAME));
            }
        } catch (final SerialisationException se) {
            throw new IllegalArgumentException(se.getMessage());
        }

        this.jobId = jobId;
        this.userId = userId;
        this.startTime = System.currentTimeMillis();
        this.status = jobStatus;
        this.description = description;
    }

    public JobDetail(final String jobId, final String userId, final OperationChain<?> opChain, final JobStatus jobStatus, final String description, final Repeat repeat) {
        try {
            if (opChain instanceof OperationChainDAO) {
                this.opChain = new String(JSONSerialiser.serialise(opChain), Charset.forName(CHARSET_NAME));
            } else {
                final OperationChainDAO dao = new OperationChainDAO(opChain.getOperations());
                this.opChain = new String(JSONSerialiser.serialise(dao), Charset.forName(CHARSET_NAME));
            }
        } catch (final SerialisationException se) {
            throw new IllegalArgumentException(se.getMessage());
        }

        this.jobId = jobId;
        this.userId = userId;
        this.startTime = System.currentTimeMillis();
        this.status = jobStatus;
        this.description = description;
    }

    public JobDetail(final String jobId, final String parentJobId, final String userId, final OperationChain<?> opChain, final JobStatus jobStatus, final String description, final Repeat repeat) {
        try {
            if (opChain instanceof OperationChainDAO) {
                this.opChain = new String(JSONSerialiser.serialise(opChain), Charset.forName(CHARSET_NAME));
            } else {
                final OperationChainDAO dao = new OperationChainDAO(opChain.getOperations());
                this.opChain = new String(JSONSerialiser.serialise(dao), Charset.forName(CHARSET_NAME));
            }
        } catch (final SerialisationException se) {
            throw new IllegalArgumentException(se.getMessage());
        }

        this.jobId = jobId;
        this.parentJobId = parentJobId;
        this.userId = userId;
        this.startTime = System.currentTimeMillis();
        this.status = jobStatus;
        this.description = description;
    }

    public JobDetail(final String jobId, final String parentJobId, final String userId, final String opChain, final JobStatus jobStatus, final String description) {

        this.opChain = opChain;
        this.jobId = jobId;
        this.userId = userId;
        this.startTime = System.currentTimeMillis();
        this.status = jobStatus;
        this.description = description;
        this.parentJobId = parentJobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(final String jobId) {
        this.jobId = jobId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(final JobStatus status) {
        this.status = status;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(final Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(final Long endTime) {
        this.endTime = endTime;
    }

    public String getOpChain() {
        return opChain;
    }

    public void setParentJobId(final String parentJobId) {
        this.parentJobId = parentJobId;
    }

    public String getParentJobId() {
        return parentJobId;
    }

    public void setOpChain(final String opChain) {
        this.opChain = opChain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj || getClass() != obj.getClass()) {
            return false;
        }
        final JobDetail jobDetail = (JobDetail) obj;
        return new EqualsBuilder()
                .append(jobId, jobDetail.jobId)
                .append(userId, jobDetail.userId)
                .append(opChain, jobDetail.opChain)
                .append(startTime, jobDetail.startTime)
                .append(endTime, jobDetail.endTime)
                .append(status, jobDetail.status)
                .append(description, jobDetail.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(23, 53)
                .append(jobId)
                .append(userId)
                .append(opChain)
                .append(startTime)
                .append(endTime)
                .append(status)
                .append(description)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("jobId", jobId)
                .append("userId", userId)
                .append("status", status)
                .append("startTime", startTime)
                .append("endTime", endTime)
                .append("opChain", opChain)
                .append("description", description)
                .toString();
    }

    private <T> T getNewOrOld(final T oldValue, final T newValue) {
        return null == newValue ? oldValue : newValue;
    }
}
