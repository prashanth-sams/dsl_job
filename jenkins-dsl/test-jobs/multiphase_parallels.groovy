multiJob("multiphase_parallel") {
	description("multi phase job")

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
