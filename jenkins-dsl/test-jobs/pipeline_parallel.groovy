multiJob("pipeline_parallel") {
	description("multi phase job inside a multi phase job")

	steps {
		phase("Parallel Test") {
			phaseJob("allure_behave_new") {
				killPhaseCondition("NEVER")
			}
			phaseJob("allure_behave_old") {
				killPhaseCondition("NEVER")
			}
			phase("Parallel Test 2") {
				phaseJob("allure_behave") {
					killPhaseCondition("NEVER")
				}
			}

			continuationCondition("ALWAYS")
			executionType("PARALLEL")
		}
	}
}
