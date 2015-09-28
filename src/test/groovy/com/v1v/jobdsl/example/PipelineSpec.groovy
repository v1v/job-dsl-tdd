package com.v1v.jobdsl.example

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobParent
import spock.lang.Specification

@Mixin(JobSpecMixin)
class PipelineSpec extends Specification {

    JobParent jobParent = createJobParent()
    Pipeline builder

    def setup() {
        builder = new Pipeline(
            name: 'test-job'
        )
    }

    void 'test platform'() {
        given: "a linux label"
        builder.label = 'linux'

        when: "the job is created"
        Job job = builder.build(jobParent)

        then: "the job should have been assigned and shell based"
        with(job.node) {
            name() == 'project'
            assignedNode.text() == 'linux'
            builders.hudson.tasks.Shell != null
        }
    }
}
