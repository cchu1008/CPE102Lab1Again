import math

class Circle:
   def __init__(self, radius):
      self.radius = radius
      
   def area(self):
      area = math.pi * (self.radius ** 2)
      return area

class Square:
   def __init__(self, side):
      self.side = side
   
   def area(self):
      area = self.side ** 2
      return area      

class Rectangle:
   def __init__(self, width, height):
      self.width = width
      self.height = height

   def area(self):
      area = self.width * self.height
      return area