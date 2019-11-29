from django.db import models
from django.utils import timezone
import datetime

# Members will eventually register for conferences and events within conferences
# members register at a certain time, and are active for 365 days from then.
class Member(models.Model):
    first_name = models.CharField(max_length=20)
    last_name = models.CharField(max_length=20)
    address_street = models.CharField(max_length=20)
    address_city = models.CharField(max_length=20)
    register_date = models.DateTimeField()
    def __str__(self):
        return self.last_name

    def active(self):
        now = timezone.now()
        return now - datetime.timedelta(days=365) <= self.register_date <= now

# A weekend conference, generally filled with events.
class Conference(models.Model):
    name = models.CharField(max_length=20)
    description = models.TextField(max_length=500)
    location = models.CharField(max_length=20)
    members = models.ManyToManyField(Member)
    def __str__(self):
        return self.name

# Event is associated with (part of) a conference.  A conference consists
# of a weekend of events at a certain location (address).  The events are a few
# hours at a time, such as a dinner, or a seminar, throughout the conference weekend.
# votes as best event (mostly so that we can make a chart)
class Event(models.Model):
    conference = models.ForeignKey(Conference, on_delete=models.CASCADE)
    name = models.CharField(max_length=20)
    location = models.CharField(max_length=20)
    date = models.DateTimeField()
    description = models.TextField(max_length=500)
    votes = models.IntegerField(default=0)
    members = models.ManyToManyField(Member)
    def __str__(self):
        return self.name

# Announcements are released every few weeks and notify members of upcoming
# conferences, and other interesting news of the membership.
class Announcement(models.Model):
    name = models.CharField(max_length=20)
    description = models.TextField(max_length=500)
    date = models.DateTimeField()
    def __str__(self):
        return self.name
