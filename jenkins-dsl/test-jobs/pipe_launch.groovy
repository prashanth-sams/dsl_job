pipelineJob('pipe_launch_new') {
    definition {
        cps {
            script(readFileFromWorkspace('./jenkins-dsl/test-jobs/pipe_launch_jenkinsfile.groovy'))
            sandbox()
        }
    }
}
