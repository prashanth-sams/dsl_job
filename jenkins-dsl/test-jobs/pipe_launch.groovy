pipelineJob('pipe_launch') {
     blockOn(['allure_behave_new', 'allure_behave_latest_2']) {
        blockLevel('GLOBAL')
        scanQueueFor('ALL')
    }
    definition {
        cps {
            script("""
              node {
                try {
                  stage('allure_behave') {
                    build(job: 'allure_behave')
                    def desktop_job_data = Jenkins.instance.getItemByFullName("allure_behave")
                    desktop_build = desktop_job_data.getLastBuild().result.toString()
                  }
                } catch(e) {
                  echo e.toString()
                }
                try {
                    stage('allure_behave_latest') {
                      build(job: 'allure_behave_latest')
                      def mdot_job_data = Jenkins.instance.getItemByFullName("allure_behave_latest")
                      mdot_build = mdot_job_data.getLastBuild().result.toString()
                    }
                } catch(e) {
                    echo e.toString()
                }
                if(desktop_build == "FAILURE" || mdot_build == "FAILURE") {
                    currentBuild.result = "FALIURE"
                } else if (desktop_build == "SUCCESS" && mdot_build == "SUCCESS") {
                    currentBuild.result = "SUCCESS"
                } else if (desktop_build == "ABORTED" || mdot_build == "ABORTED") {
                    currentBuild.result = "ABORTED"
                } else {
                    currentBuild.result = "UNSTABLE"
                }
              }
            """)
            sandbox()
        }
    }
}
