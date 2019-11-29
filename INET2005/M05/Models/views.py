from django.views import generic

from .models import *


class IndexView(generic.ListView):
    template_name = 'Models/index.html'
    context_object_name = 'model'

    def get_queryset(self):
        return Course.objects.all()


class StudentView(generic.ListView):
    model = Student
    template_name = 'Models/student_list.html'
    context_object_name = 'student'


class ClassView(generic.ListView):
    model = Course
    template_name = 'Models/class_list.html'
    context_object_name = 'course'


class StudentDetail(generic.DetailView):
    model = Student
    template_name = 'Models/student_detail.html'
    # context_object_name = 'student'


class ClassDetail(generic.DetailView):
    model = Course
    template_name = 'Models/class_detail.html'
    # context_object_name = 'student'


class ChartView(generic.ListView):
    model = Course
    template_name = 'Models/chart.html'
    # context_object_name = 'course'

    def get_queryset(self):
        courseData = {}
        for course in Course.objects.all():
            courseData[course] = 0
        for student in Student.objects.all():
            for course in student.student_courses.all():
                courseData[course] += 1
        print(courseData)
        stringData = {}
        for course in courseData:
            stringData[course.course_name] = courseData[course]
        return stringData

    # context_object_name = 'student'
