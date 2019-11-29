from django.db import models


class Day(models.Model):
    day = models.CharField(max_length=200)

    def __str__(self):
        return self.day


class Time(models.Model):
    class_time = models.CharField(max_length=200)

    def __str__(self):
        return self.class_time


class Course(models.Model):
    course_name = models.CharField(max_length=200)
    course_days = models.ManyToManyField(Day)
    course_time = models.ManyToManyField(Time)

    def __str__(self):
        return self.course_name


class Student(models.Model):
    student_name = models.CharField(max_length=200)
    student_courses = models.ManyToManyField(Course)

    def __str__(self):
        return self.student_name




