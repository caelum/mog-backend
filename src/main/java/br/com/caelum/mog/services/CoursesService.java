package br.com.caelum.mog.services;

import org.springframework.stereotype.Service;

import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.Platform;
import br.com.caelum.mog.rest.ClassroomCoursesRestClient;
import br.com.caelum.mog.rest.CoursesRestClient;
import br.com.caelum.mog.rest.OnlineCoursesRestClient;
import org.springframework.util.Assert;

@Service
public class CoursesService {

	private OnlineCoursesRestClient onlineClient;
	private ClassroomCoursesRestClient classroomClient;

	public CoursesService(OnlineCoursesRestClient onlineClient, ClassroomCoursesRestClient classroomClient) {
		this.onlineClient = onlineClient;
		this.classroomClient = classroomClient;
	}
	
    public Course getCourseByCodeAndPlatform(String code, Platform platform) {
        Assert.hasText(code, "Code required");
        Assert.notNull(platform, "Platform required");

    	return getClientByPlatform(platform).getCourseByCode(code);
    }

    
    private CoursesRestClient getClientByPlatform(Platform platform) {
    		return platform.equals(Platform.ONLINE)? onlineClient: classroomClient;
    }
}
