from django.urls import path

from . import views

app_name = 'Models'

urlpatterns = [
    path('', views.IndexView.as_view(), name='index'),
    path('student_list', views.StudentView.as_view(), name='student'),
    path('class_list', views.ClassView.as_view(), name='class'),
    path('<int:pk>/StudentDetails', views.StudentDetail.as_view(), name='studentDetail'),
    path('<int:pk>/ClassDetails', views.ClassDetail.as_view(), name='classDetail'),
    path('chart', views.ChartView.as_view(), name='chart'),
]