from django.contrib import admin

from .models import *

admin.site.register(Day)
admin.site.register(Course)
admin.site.register(Time)
admin.site.register(Student)

# Register your models here.
