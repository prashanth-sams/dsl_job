pipelineJob('pipe_launch_new') {
    definition {
        cps {
            scriptPath('pipe_launch_jenkinsfile')
            sandbox()
        }
    }
}
