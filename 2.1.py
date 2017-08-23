# def frequency(lst):

def square(n):
	square=n*n
	return square
def sqrsum(n):
	sum=0
	for i in n:
		sum+=square(i)
	return sum
def sqrt(n):
	sqrt=sqrsum(n)**0.5
	return sqrt
def cosangle(x,y):
	cosangle=sum/(sqrt(d1)*sqrt(d3))
	return cosangle
def percent(x,y):
	percent=cosangle(x,y)*100
	return percent

from functools import reduce

f=open("testfile.txt","r")
f1=open("testfile1.txt","r")

s1=str(f.readlines()) #"to be or not to be"
s2=str(f1.readlines()) #"doubt truth to be a liar "
p=reduce(lambda d,c:d.update([(c,d.get(c,0)+1)])or d,s1.split(),{})
p1=reduce(lambda d,c:d.update([(c,d.get(c,0)+1)])or d,s2.split(),{})

print(int(p))
print(int(p1))


def mul(p,p1):
	temp=0
	sum=0
	for i in p:
		for j in p1:
			if i==j:
				temp+=p[i]*p1[j]
				sum+=temp
	print(temp)
	return sum


# d=list(p.keys())
# d1=list(p.values())
# d2=list(p1.keys())
# d3=list(p1.values())

# print(d1)
# print(d3)
# lst=[]
# for i in range(len(d)):
# 	for j in range(len(d2)):
# 		if d[i]==d2[j]:
# 			lst.append(d[i])
# # print(lst)
# lst=set(lst)
# p=set(p)
# k=p.intersection(lst)
# print(k)
# k1=dict(zip(k,d3))


# del k1["['"]
# del k1["']"]

# print(k1)


# k2=list(k1.values())
# print(k2)
# m=len(d1)
# n=len(k2)


# if m<n:
# 	lst1=d1
# 	diff=n-m
# 	# print(diff)	
# 	for i in range(m,diff,-1):
# 		# print(i)
# 		lst1.append(0)
# else:
# 	lst1=k2
# 	diff=m-n
# 	print(diff)
# 	for i in range(n,diff,1):

# 		lst1.append(0)
# print (lst1)
# sum=0
# for i in range(0,len(k2)):

# 	mul=lst1[i]*d1[i]
# 	sum+=mul

# print(sum)
# print (percent(s1,s2))

print(mul(s1,s2))


