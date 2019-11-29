from django.contrib import admin
from .models import Announcement, Member, Conference, Event

# Register all 4 tables for admin edit/update
admin.site.register(Announcement)
admin.site.register(Member)
admin.site.register(Conference)
admin.site.register(Event)
