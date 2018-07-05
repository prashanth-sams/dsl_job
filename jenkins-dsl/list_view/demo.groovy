multiJob('demo') {
    description 'Multijob Project to start staging tests in parallel'

    steps {
         phase('demo') {
            phaseJob('allure_behave')
            phaseJob('allure_behave_new')
            phaseJob('allure_behave_old')
        }


    }

    configure { project ->
      project / publishers << 'jenkins.plugins.slack.SlackNotifier' {
        baseUrl("https://hooks.slack.com/services/T06GZB2GY/")
        room("#tests")
        notifyAborted(false)
        notifyFailure(true)
        notifyNotBuilt(false)
        notifyUnstable(false)
        notifyBackToNormal(false)
        notifySuccess(true)
        notifyRepeatedFailure(false)
        startNotification(true)
        includeTestSummary(false)
        includeCustomMessage(true)
        customMessage("@here Excuse me! I've something for you")
        sendAs(null)
        commitInfoChoice("NONE")
        teamDomain("pickoh")
        authTokenCredentialId("BBK5DE0HH/aCLerZmLOjHUczI6jEc6RgA0")
      }
    }
}
