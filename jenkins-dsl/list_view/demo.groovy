multiJob('demo') {
    description 'Multijob Project to start staging tests in parallel'

    steps {
         phase('demo') {
            phaseJob('allure_behave')
            phaseJob('allure_behave_new')
            phaseJob('allure_behave_old')
        }


    }

    publishers {
      slackNotifier {
        teamDomain('pickoh')
        baseUrl('https://hooks.slack.com/services/T06GZB2GY/')
        authToken('BBK5DE0HH/aCLerZmLOjHUczI6jEc6RgA0')
        room('tests')
        startNotification(true)
        notifyNotBuilt(false)
        notifyAborted(false)
        notifyFailure(true)
        notifySuccess(true)
        notifyUnstable(false)
        notifyBackToNormal(false)
        notifyRepeatedFailure(false)
        includeTestSummary(false)
        includeCustomMessage(true)
        customMessage("@here Excuse me! I've something for you")
        sendAs(null)
        commitInfoChoice('NONE')
    }
  }
}
