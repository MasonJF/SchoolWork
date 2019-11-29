from django.db import models


class Owner(models.Model):
    owner_name = models.CharField(max_length=200)
    phone_number = models.CharField(max_length=200)
    street_address = models.CharField(max_length=200)

    def __str__(self):
        return self.owner_name


class Pet(models.Model):
    pets_owner = models.ForeignKey(Owner, on_delete=models.CASCADE)
    pet_name = models.CharField(max_length=200)
    pet_type = models.CharField(max_length=200)

    def __str__(self):
        return self.pet_name

