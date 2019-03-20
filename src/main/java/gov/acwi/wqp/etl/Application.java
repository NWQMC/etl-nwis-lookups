package gov.acwi.wqp.etl;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableBatchProcessing
@Profile("default")
public class Application implements CommandLineRunner {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job nwisEtlLookupJob;
	

	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		JobParametersBuilder parameterBuilder = new JobParametersBuilder();
		parameterBuilder.addDate("current_date", new Date());
		jobLauncher.run(nwisEtlLookupJob, parameterBuilder.toJobParameters());
	}
}
