package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.algo.AlgoClass;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ChannelTrafficApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChannelTrafficApplication.class, args);
	}

	@PostConstruct
	public void test() {
		LL list=new LL();
		list.insertAtLastWithoutTail(1);
		list.insertAtLastWithoutTail(2);
		list.insertAtLastWithoutTail(3);
		list.insertAtLastWithoutTail(4);
		list.insertAtLastWithoutTail(3);
		list.insertAtLastWithoutTail(2);
		list.insertAtLastWithoutTail(1);
		list.display(list);
		list.reverse();
		list.display(list);
		
		
		
//		LL list2=new LL();
//		list2.insertAtLastWithoutTail(3);
//		list2.insertAtLastWithoutTail(4);
//		list2.insertAtLastWithoutTail(5);
//		list2.insertAtLastWithoutTail(6);
//		list2.insertAtLastWithoutTail(6);
//		list2.insertAtLastWithoutTail(7);
//		list2.insertAtLastWithoutTail(8);
//		list2.insertAtLastWithoutTail(9);
//		list2.display();
//		
//		LL sortedList = list.merge2SortedList(list, list2);
//		list.display(sortedList);
		
//		list.removeDuplicateSorted();
//		list.display();
//		list.reverse();
//		list.display();
//		list.display();
////		list.insertAtFirst(1);
//		list.insertAtLast(1);
//		list.insertAtLast(2);
//		list.insertAtLastWithoutTail(3);
//		list.insertAtPos(4, 1);
//		list.insertAtPos(5, 4);
//		list.insertAtPos(6, 3);
//		list.insertAtFirst(7);
//		list.insertAtLastWithoutTail(8);
//		list.insertAtPos(9, 7);
//		list.insertAtPos(11, 3);
////		list.deleteFirst();
//		list.display();
//		list.deleteFirst();
//		list.display();
//		list.deleteLast();
//		list.display();
////		list.deleteAtPos(7);
//		list.deleteAtPos(3);
//		list.display();
//		list.deleteAtPos(6);
//		list.display();
//		list.deleteAtPos(1);
//		list.display();
//		System.out.println(list.getSize());
	}
	
//	@PostConstruct
	public void sort() {
		
		int[] arr= {1,10,4,2,5,6,3,9};
		int n=arr.length;
		AlgoClass.quick(arr,0,n-1);
		System.out.println(Arrays.toString(arr));
		System.out.println(AlgoClass.binary(arr, 0, n-1, 10));
		
		
//		selection sort
//		for(int i=0;i<arr.length-1;i++) {
//			int min_idx=i;
//			for(int j=i+1;j<arr.length;j++) {
//				if(arr[j]<arr[min_idx]) {
//					min_idx=j;
//				}
//			}
//			int temp=arr[min_idx];
//			arr[min_idx]=arr[i];
//			arr[i]=temp;
//		}
		
		//bubble sort
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr.length-i-1;j++) {
//				if(arr[j]>arr[j+1]) {
//					int temp=arr[j+1];
//					arr[j+1]=arr[j];
//					arr[j]=temp;
//				}
//			}
//		}
		
		//insertion sort
//		for(int i=1;i<arr.length;i++) {
//			int key=arr[i];
//			int j=i-1;
//			while(j>=0 && arr[j]>key) {
//				arr[j+1]=arr[j];
//				j=j-1;
//			}
//			arr[j+1]=key;
//		}
		
//		mergeSort(arr,0,arr.length-1);
		
//		quickSort(arr,0,arr.length-1);
		
//		System.out.println(Arrays.toString(arr));
	}

	private void quickSort(int[] arr, int l, int r) {
		if(l>=r) {
			return;
		}
		int s=l;
		int e=r;
		int mid=s+(e-s)/2;
		int pivot=arr[mid];
		
		while(s<=e) {
			
			while(arr[s]<pivot) 
				{
				s++;
				}
			while(arr[e]>pivot) {
				e--;
				}
		
			if(s<=e) {
				int temp=arr[s];
				arr[s]=arr[e];
				arr[e]=temp;
				s++;
				e--;
			}
		}
		quickSort(arr,l,e);
		quickSort(arr,s,r);
		}
		

	private void mergeSort(int[] arr, int l, int r) {
		
		if(l<r) {
			int mid=l+(r-l)/2;
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,r);
			
			merge(arr,l,mid,r);
			
		}
		
	}

	private void merge(int[] arr, int l, int mid, int r) {
		int k=l;
		int n1=mid-l+1;
		int n2=r-mid;
		int[] arr1=new int[n1];
		int[] arr2=new int[n2];
		for(int i=0;i<n1;i++) {
			arr1[i]=arr[l+i];
		}
		for(int j=0;j<n2;j++) {
			arr2[j]=arr[mid+1+j];
		}
		
		int i=0,j=0;
		while(i<n1 && j<n2) {
			if(arr1[i]<=arr2[j]) {
				arr[k]=arr1[i];
				i++;k++;
			}else {
				arr[k]=arr2[j];
				j++;k++;
			}
		}
		while(i<n1) {
			arr[k]=arr1[i];
			i++;k++;
		}
		while(j<n2) {
			arr[k]=arr2[j];
			j++;k++;
		}
	}
	
}
