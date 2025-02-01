import matplotlib.pyplot as plt

plt.xlabel('The range of carsMain and carsSide', fontdict={'family' : 'Times New Roman', 'size'   : 16})#x轴标签
plt.ylabel('Synthesis Time (s)', fontdict={'family' : 'Times New Roman', 'size'   : 16})#y轴标签

x1 = [5,10,15,20,25,30,35]
# 843900
y1 = [0.232833333, 1.925333333, 6.703, 32.54833333, 64.525, 174.2355, 383.317]
y2 = []
for i in y1:
    y2.append(i/1000)
# x2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30]
# y2 = [99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14, 99.14]

plt.plot(x1,y1,'-o',ms=5)
# plt.plot(x2,y2,'-go',ms=5)
plt.plot(x1,y2,'-o',ms=5)

# plt.text(20, 174.5, 'Boolean encoded method', fontsize=13, style='italic')

# plt.text(25, 5, 'Our method', fontsize=13, style='italic')

plt.legend(['Boolean encoded method',"Our method"], fontsize=12)

plt.savefig('SynTime.pdf', bbox_inches='tight')
# fig.savefig(‘test.pdf’, bbox_inches=‘tight’)

plt.show()