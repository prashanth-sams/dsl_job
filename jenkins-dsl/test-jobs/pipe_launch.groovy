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

              try {
                  stage('allure_behave_latest') {
                    build(job: 'allure_behave_latest')
                    def mdot_job_data = Jenkins.instance.getItemByFullName("allure_behave_latest")
                    mdot_build = mdot_job_data.getLastBuild().result.toString()
                    echo (mdot_job_data.getLastBuild().result.toString())
                  }
              } catch(e) {
                  def mdot_job_data = Jenkins.instance.getItemByFullName("allure_behave_latest")
                  mdot_build = mdot_job_data.getLastBuild().result.toString()
                  echo (mdot_job_data.getLastBuild().result.toString())
                  echo (mdot_job_data.getLastBuild().getNumber().toString())
                  echo e.toString()
              }
            """)
            sandbox()
        }
    }
}
