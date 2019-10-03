package com.paulosetest.springbatch;

import java.io.File;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class FileDeletingTasklet implements Tasklet {

	private File file;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)  {
		 System.out.println(file.getAbsolutePath());
         boolean deleted = file.delete();
         if (!deleted) {
             throw new UnexpectedJobExecutionException("Could not delete file " + file.getPath());
         }else {
        	 System.out.println("Deleted file from "+ file.getAbsolutePath());
         }
		return RepeatStatus.FINISHED;
	}

	public File getResources() {
		return file;
	}

	public void setResources(File resource) {
		this.file = resource;
	}

}