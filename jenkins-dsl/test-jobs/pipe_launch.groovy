pipelineJob('pipe_launch_new') {
    definition {
        cps {
            script("""
              node {
                stage('allure_behave') {
                  build(job: 'allure_behave')
                  echo 'hello'
                }
              }
            """)
            sandbox()
        }
    }
}
