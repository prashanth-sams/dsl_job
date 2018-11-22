multiJob("parallels") {
	description("multi phase job inside a multi phase job")

	concurrentBuild(false)
	steps {
		phase("Parallel Test") {
			phaseJob("allure_behave") {
				killPhaseCondition("NEVER")
			}
			phaseJob("allure_behave_new") {
				killPhaseCondition("NEVER")
			}
			phaseJob("allure_behave_old") {
				killPhaseCondition("NEVER")
			}
			continuationCondition("ALWAYS")
			executionType("PARALLEL")
		}
	}
}
