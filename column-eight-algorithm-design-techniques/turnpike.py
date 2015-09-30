class DistanceStruct(object):
	def __init__(self, distances):
		self.prefix = [0] * len(distances)
		self._calculate_prefixes(distances)
		self.distances = distances

	def _calculate_prefixes(self, distances):
		self.prefix[0] = distances[0]
		for i in xrange(1, len(distances)):
			self.prefix[i] = self.prefix[i - 1] + distances[i]

	def distance(self, station_one, station_two):
		if station_one > station_two:
			station_one, station_two = station_two, station_one

		answer = self.prefix[station_two] - self.prefix[station_one] 
		answer = answer + self.distances[station_one]
		return answer