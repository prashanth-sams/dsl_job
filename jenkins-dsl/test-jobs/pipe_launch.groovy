pipelineJob('pipe_launch_new') {
    definition {
        cps {
            sandbox()
            script(readFileFromWorkspace('./jenkins-dsl/test-jobs/hello.groovy'))
        }
    }
}
