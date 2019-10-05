from django.urls import path

from . import views

urlpatterns = [
    # ex: /polls/
    path('', views.IndexView.as_view(), name='index'),
    # ex: /polls/5/
    path('<int:pk>/', views.DetailView.as_view(), name='details'),
    # ex: /polls/5/results/
    path('master', views.MasterView.as_view(), name='master'),
    # ex: /polls/5/vote/
    path('masterShart', views.ResultsView.as_view(), name='masterShart'),
]