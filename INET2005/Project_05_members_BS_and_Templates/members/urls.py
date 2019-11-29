
from django.urls import path

from . import views

# URLs
#  http://127.0.0.1:8000/admin/
# Announcements:
#  http://127.0.0.1:8000/members/
#  http://127.0.0.1:8000/members/1/
# members
#  http://127.0.0.1:8000/members/members/
#  http://127.0.0.1:8000/members/1/member/
# conferences
#  http://127.0.0.1:8000/members/conferences/
#  http://127.0.0.1:8000/members/1/conference/
# Events
#  http://127.0.0.1:8000/members/events/
#  http://127.0.0.1:8000/members/1/event/

app_name = 'members'
urlpatterns = [
    path('', views.AnnouncementsView.as_view(), name='announcements'),
    path('<int:pk>/', views.AnnouncementView.as_view(), name='announcement_results'),
    path('members/', views.MembersView.as_view(), name='members'),
    path('<int:pk>/member/', views.MemberView.as_view(), name='member_results'),
    path('conferences/', views.ConferencesView.as_view(), name='conferences'),
    path('<int:pk>/conference/', views.ConferenceView.as_view(), name='conference_results'),
    path('events/', views.EventsView.as_view(), name='events'),
    path('<int:pk>/event/', views.EventView.as_view(), name='event_results'),
]
