#Protocol explanation

Could probably do better than base 64 in sms
Ascii 85 might work well

##Base protocol
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 chars (64 unsigned numbers) checksum (This will need to be custom written)
1 ASCII char command type
132 base 64 chars payload


##Pictures

### Begin picture
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 chars checksum 
B

### End picture
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 chars checksum
E


###Picture payload
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 chars checksum 
P
1 base 64 chars (64) picture topic (used to determine what picture this is talking about) 
134 base 64 chars payload

132 * 6 = 804 bits
805 / 8 = ~100 bytes
1 kb = 1000 bytes
10 sms for 1 kb
10 kb image = 100 texts
jpeg might work for making 2kb ish images (20 texts?)

Images could be reasonably scaled down to 10kb


##NMEA Extension (GPS type stuff)
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 char checksum 
N
82 bit ascii nmea string (nmea has checksum, maybe don't need but would have to write custom parser)


##Command extension
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 chars (262144 unsigned numbers) checksum (This will need to be custom written)
2 ascii chars  mnemonic
4 base 64 chars (4 bytes) payload

###Move forward
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 chars checksum 
F
4 bytes base 64 - duration

###Turn left
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 chars checksum 
L
4 bytes base 64 - duration

###Turn right
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 chars checksum 
R
4 bytes base 64 - duration


###Take picture
3 base 64 chars (262144 unsigned numbers) message number
1 base 64 chars checksum 
T
4 bytes base 64 - unused (could be resolution?)

