pipelineJob('pipe_launch_new') {
    definition {
        cps {
            script("""
pipeline {
    agent any
    stages {
        stage('parallel tests') {
            parallel {
                stage('parallel 1 - allure_behave') {
                    steps {
                        script {
                            try {
                                build(job: 'allure_behave')
                                def desktop_job_data = Jenkins.instance.getItemByFullName("allure_behave_latest")
                                desktop_build = desktop_job_data.getLastBuild().result.toString()
                                desktop_build_no = desktop_job_data.getLastBuild().getNumber().toString()
                            } catch(e) {
                                echo e.toString()
                            }
                        }
                    }
                }
                stage('parallel 2 - allure_behave_old') {
                    steps {
                        script {
                            try {
                                build(job: 'allure_behave_old')
                                def mdot_job_data = Jenkins.instance.getItemByFullName("allure_behave_old")
                                mdot_build = mdot_job_data.getLastBuild().result.toString()
                                mdot_build_no = mdot_job_data.getLastBuild().getNumber().toString()
                            } catch (e) {
                                echo e.toString()
                            }
                        }        
                    }
                }
            }
        }

        stage('tear down') {
            steps {
                script {
                    echo(desktop_build + " :" + desktop_build_no)
                    echo(mdot_build + " :" + mdot_build_no)

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
            }
        }
    }
}
            """)
            sandbox()
        }
    }
}
