'''TO FIND PLAGARISM USING BAG OF WORDS'''


class Plagarism(object):

	def noduplicates(self,p):		#to remove duplicates
		l=[]
		for i in p:
			if i not in l:
				l.append(i)
		return l
	# def square(self,n):
	# 	square=n*n
	# 	return square
	# def sqrsum(self,n):

	# 	return sum
	def sqrt(self,n): 				#to find squareroot for the given no.
		sqrsum=0
		for i in n:
			square=i*i
			sqrsum+=square#(i)		#to find sum of squares
		sqrt=sqrsum**0.5
		return sqrt
	def mul(self,p,q):				#to find the product of lists
		sum=0
		l=list(p.values())
		l1=list(q.values())
		n=len(l)
		n1=len(l1)
		i=0
		while i<n:
			sum+=int(l[i])*int(l1[i])
			i=i+1
		return sum
	def frequency(self,p,q):		#to find frequency
		l=[]
		d={}
		for i in p:
			temp=0
			for j in q:
				if i==j:
					temp=temp+1
			l.append(temp)
		d=dict(zip(p,l))
		return d

import re

def fopen(name):			#to open the file
	k=open(name)
	r1=k.read()
	r1=r1.lower()
	r1=re.sub(r'\W',' ',r1)
	return r1

def bagofwords(file1,file2): 		#main function
	l=Plagarism()
	p1=fopen(file1)
	# print(p1)
	q1=fopen(file2)
	# print(q1)

	s=p1.split()
	s1=q1.split()
	c=s+s1
	# print(c)
	c1=l.noduplicates(c)
	p=l.frequency(c1,s)
	# print(p)
	q=l.frequency(c1,s1)
	# print(q)
	dotprod=l.mul(p,q)
	# print(dotprod)
	v=p.values()
	v1=q.values()
	# print(v)
	a=l.sqrt(v)
	# print(a)
	b=l.sqrt(v1)
	sqrtproduct=a*b
	angle=dotprod/sqrtproduct
	return angle*100 

import os,glob

h=[]
path=input('enter the directory')
for file in os.listdir(path):				#to open the folder
	print(file)
	h.append(file)
# print(h)

w=[]
for i in h:
	for j in h:
		h1=bagofwords(str(i),str(j))
		# print(h1)
		w.append(round(h1,2))

# print(w)

for i in range(0,len(w),len(h)):
	print(w[i:i+len(h)])



# file1="to be or not to be"
# file2="doubt truth to be a liar"
# print(bagofwords(file1,file2))
