pipelineJob("pipeline_parallel_pro") {
	description("pipeline job to execute parallel jenkins jobs")
	keepDependencies(false)
	definition {
		cpsScm {
			scm {
				git {
					remote {
						github("prashanth-sams/jenkinsfile", "https")
					}
					branch("*/master")
				}
			}
			scriptPath("pipeline_parallel")
		}
	}
	disabled(false)
}
