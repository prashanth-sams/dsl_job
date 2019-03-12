definition {
  stage ('allure_behave') {
    build(job: 'allure_behave')
  }
}
