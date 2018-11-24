pipelineJob("pipeline_multi_parallel_blocks") {
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
			scriptPath("pipeline_parallel_groups")
		}
	}
	disabled(false)
}
