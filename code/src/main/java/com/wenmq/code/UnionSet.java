package com.wenmq.code;

/**
 * @author ifans.wen
 * @date 2020/3/16
 * @description
 */

import java.util.Random;

public class UnionSet {

    private int count;// Ԫ������
    private int[] rank; // ����
    private int[] parent;// �ڵ�

    UnionSet(int count) { //��ʼ������
        this.count = count;
        rank = new int[count];
        parent = new int[count];

        for (int i = 0; i < count; i++) {
            rank[i] = 1;
            parent[i] = i;

        }

    }

    public void union(int p, int q) { // �ϲ�����Ԫ��

        int pRoot = find(p); //��λ������ڵ�
        int qRoot = find(q);
        if (pRoot == qRoot) //�����������ȣ�֤���Ѿ������Ӻõģ������ٺϲ�
            return;

        if (rank[pRoot] > rank[qRoot]) { //���p���ڵ�Ĳ�������q�ģ���ô��qRoot�ӵ�pRoot���棬�����Ӻ��Ժ�㼶��������
            parent[qRoot] = pRoot;

        } else if (rank[pRoot] < rank[qRoot]) {

            parent[pRoot] = qRoot;
        } else //������ڣ�������ı߲㼶�����һ
        {
            parent[pRoot] = qRoot;
            rank[qRoot] = rank[qRoot] + 1;
        }


    }

    public int find(int p) {// ����Ԫ�� ���ظ�Ԫ��

        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; //·��ѹ��
            p = parent[p];
        }

        return p;
    }

    public boolean isConnected(int p, int q) {

        return find(p) == find(q);
    }

    public static void test() {
        UnionSet uf = new UnionSet(10);
        int[] a = {1, 1, 1, 5, 3, 2, 2, 4, 4};
        int[] b = {9, 7, 6, 1, 2, 3, 4, 3, 8};
        for (int i = 0; i < a.length; i++) {
            uf.union(a[i], b[i]);
        }
//        for (int i = 0; i < uf.count; i++) {
//            for (int j = i + 1; j < uf.count; j++) {
//                System.out.println("i=" + i + " j=" + j + " is connected=" + uf.isConnected(i, j));
//            }
//        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < uf.parent.length; i++) {
            sb.append(uf.parent[i] + " ");
        }
        System.out.println(sb);


    }

    public static void main1(String[] arg) {

        int N = 10000000;
        N /= 10000;
        UnionSet uf = new UnionSet(N);
        double startTime = System.currentTimeMillis();
        int tempA;
        int tempB;
        Random random = new Random();
        //����N�κϲ�����
        for (int i = 0; i < N; i++) {
            tempA = random.nextInt(N) % N;
            tempB = random.nextInt(N) % N;
            uf.union(tempA, tempB);

        }
        //����N�β���
        for (int i = 0; i < N; i++) {
            tempA = random.nextInt(N) % N;
            tempB = random.nextInt(N) % N;
            uf.isConnected(tempA, tempB);

        }

        double endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

    }


}