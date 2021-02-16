import math

class Coordinate(object):
	def __init__(self, x, y):
		self.x = x
		self.y = y
		
		
	def distance(self, other):
		xDistanceSqr = (self.x - other.x)**2
		yDistanceSqr = (self.y - other.y)**2
		return (xDistanceSqr + yDistanceSqr)**0.5
			

#implementationExample

a = Coordinate(3,4)
b = Coordinate(0,0)

print(a.distance(b))
