package com.code.dal.orm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "VW_ORDER")
@NamedQuery(name = "Order.all", query = "FROM OrderView ")
public class OrderView {
	private Long id;
	private Long ownerId;
	private Long placeId;
	private String name;
	private String ownerName;
	private String status;
	private String placeName;
	private Date orderDate;
	private Order order;

	public OrderView() {
		order = new Order();
	}

	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
@Transient
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setId(Long id) {
		this.id = id;
		this.order.setId(id);
	}

	@Column(name = "OWNER_ID")
	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
		this.order.setOwnerID(ownerId);
	}

	@Column(name = "PLACE_ID")
	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
		this.order.setPlaceID(placeId);
	}

	@Column(name = "ORDER_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "OWNER_NAME")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		this.order.setStatus(status);
	}

	@Column(name = "PLACE_NAME")
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Column(name = "ORDER_DATE")
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
		this.order.setDate(orderDate);
	}
}