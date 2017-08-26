'''TO FIND PLAGARISM USING  STRING MATCHING'''



def lcs(p,q):		#to find least common substring
	
	k=0
	maxcount=0

	for k in range(len(p)):
		j=0
		for j in range(len(q)):
			h=0
			i=k
			if(p[i]==q[j]):
				while (((i<len(p)) and (j<len(q))) and (p[i]==q[j])):
					h+=len(p[i])
					i+=1
					j+=1
				
			if(h>maxcount):
				maxcount=h
	
	if len(p)+len(q)==0:
		print("list is empty")
	else:
		prcnt=(maxcount*2*100.0)/(len(p)+len(q))		#to find the percent
		prcnt=round(prcnt,2)

	return (prcnt)



import re 			# import regular expressions
import os.path


path=input("Enter path")
L=os.listdir(path)
print(L)
os.chdir(path)


lst=[]									
for i in range (len(L)):
    for j in range (len(L)):
        if i==j:
            lst.append("100")
        else:
            p=open(L[i])
            q=open(L[j])  
            p=p.read()
            q=q.read()
            lst.append(lcs(p,q))
    print(lst)
    lst=[]

    # print(p)
    # print(q)
