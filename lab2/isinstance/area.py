import math
import sys
import classes

def area(shape):
   if isinstance(shape, classes.Circle):
      a = math.pi * (shape.radius ** 2)
      return a
   elif isinstance(shape, classes.Square):
      a = shape.side ** 2
      return a
   elif isinstance(shape, classes.Rectangle):
      a = shape.width * shape.height
      return a
   else:
      raise TypeError("Not a recognized shape")
