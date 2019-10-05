from django.http import HttpResponse
from django.http import Http404
from django.shortcuts import render, get_object_or_404
from django.views import generic

from .models import Owner, Pet


class IndexView(generic.ListView):
    template_name = 'pets/index.html'
    context_object_name = 'owners'

    def get_queryset(self):
        return Owner.objects.all()
#
# def detail(request, owner_id):
#     petnames = Pet.objects.order_by('pet_name')
#     try:
#         context = {
#             'pet_name': petnames,
#         }
#         pet_name = Pet.objects.get(pk=owner_id)
#     except Pet.DoesNotExist:
#         raise Http404("This does not exist")
#     return render(request, 'pets/details.html', {'pet_name': pet_name}, context)


class DetailView(generic.DetailView):
    model = Owner
    template_name = 'pets/details.html'


class MasterView(generic.ListView):
    template_name = 'pets/master.html'
    context_object_name = 'master'

    def get_queryset(self):
        return Pet.objects.all()



class ResultsView(generic.ListView):
    model = Pet
    template_name = 'pets/masterShart.html'

    def get_queryset(self):
        return Pet.objects.all()

