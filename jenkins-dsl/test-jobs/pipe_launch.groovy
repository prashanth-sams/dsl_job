pipelineJob('pipe_launch_new') {
    definition {
        cps {
            script(""
              stage 'allure_behave'
              echo 'hello'
            "")
            sandbox()
        }
    }
}
