pipelineJob('pipe_launch_new') {
    definition {
        cps {
            script("""
              node {
                try {
                    stage('allure_behave') {
                      build(job: 'allure_behave')
                      def desktop_job_data = Jenkins.instance.getItemByFullName("allure_behave")
                      desktop_build = desktop_job_data.getLastBuild().result.toString()
                      echo (desktop_job_data.getLastBuild().result.toString())
                    }
                } catch(e) {
                    def desktop_job_data = Jenkins.instance.getItemByFullName("allure_behave")
                    desktop_build = desktop_job_data.getLastBuild().result.toString()
                    echo (desktop_job_data.getLastBuild().result.toString())
                    echo (desktop_job_data.getLastBuild().getNumber().toString())
                    echo e.toString()
                }
              }
            """)
            sandbox()
        }
    }
}
