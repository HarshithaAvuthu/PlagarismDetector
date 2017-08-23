def noduplicates(p):
	l=[]
	for i in p:
		if i not in l:
			l.append(i)
	return l
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
def mul(p,q):
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
def frequency(p,q):
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

def bagofwords(file1,file2):
	s=file1.split()
	s1=file2.split()
	c=s+s1
	print(c)
	c1=noduplicates(c)
	p=frequency(c1,s)
	print(p)
	q=frequency(c1,s1)
	print(q)
	dotprod=mul(p,q)
	print(dotprod)
	v=p.values()
	v1=q.values()
	# print(v)
	a=sqrt(v)
	# print(a)
	b=sqrt(v1)
	sqrtproduct=a*b
	angle=dotprod/sqrtproduct
	return angle*100 


file1="to be or not to be"
file2="doubt truth to be a liar"
print(bagofwords(file1,file2))
