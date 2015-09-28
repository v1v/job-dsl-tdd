package com.v1v.jobdsl.example

import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

/**
 * Class for builder
 */
class Pipeline {

    String name
    String label

    Job build(DslFactory dslFactory) {
        dslFactory.job(name) {
            it.label label
            it.description '''
    <h3>This job is managed by github and will be overwritten.</h3>
    <h4>Do not edit this job through the web</h4>
    If you would like to make changes to this job, please see:
    <a href="https://github.com/v1v/jenkins-jobs">jenkins-jobs</a>
    '''.stripIndent().trim()
            logRotator(90, 90, 3, 7)
            jdk('jdk8-latest')
            scm {
              git {
                  remote {
                      name('remote')
                      url('https://github.com/v1v/jenkins-jobs')
                  }
                  createTag false
              }
            }
            steps {
                // TODO: shell dslFactory.readFileFromWorkspace('resources/build.sh')
                shell '''
                  echo hello'''.stripIndent().trim()
            }
            publishers {
                archiveJunit('**/junit.xml')
            }
        }
    }
}
