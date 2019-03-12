pipelineJob('pipe_launch_new') {
    definition {
        cps {
            script(readFileFromWorkspace('./pipe_launch_jenkinsfile.groovy'))
            sandbox()
        }
    }
}
