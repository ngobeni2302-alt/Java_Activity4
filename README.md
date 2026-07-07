# Activity 4: Multi-Package Architecture & Domain Interactions

In this activity, you are writing an E-Commerce warehouse service engine. Pay extra attention to package boundaries! Classes inside `com.shop.service` must explicitly `import com.shop.model.*` to look inside the data package.

---

## 📝 Specifications Sheet

### 📦 Package 1: `com.shop.model`

#### 1. `Item.java`
* **Private Variables:** `name` (String), `price` (double)
* **Constructor:** Sets both fields. Protect `price` by filtering it through the setter.
* **Encapsulation:** Standard getters. Setter for `price`: 
* If price is less than `0.0`, force it to `0.0`.

#### 2. `Order.java`
* **Private Variables:** `orderId` (String), `item` (Item), `shippingMethod` (String)
* **Constructor:** Maps all 3 fields.
* **Encapsulation:** Create getters for all three fields. (No setters required).

#### 3. `Shipment.java`
* **Private Variables:** `totalCost` (double), `trackingDetails` (String)
* **Constructor:** Maps both fields.
* **Encapsulation:** Create getters for both fields.

---

### ⚙️ Package 2: `com.shop.service`

#### 4. `FulfillmentService.java`
* **Methods:**
  * `public Shipment processOrder(Order order)`: Return a basic default `Shipment` object
  * with a total cost matching the order's item price directly, and tracking details set to
  * `"Generic Processing"`.

#### 5. `StandardFulfillment.java` (Inherits from `FulfillmentService`)
* **Polymorphic Method Override:**
  * Override `processOrder(Order order)`.
  * Calculate total cost as: `order.getItem().getPrice() + 5.00` (adds a $5 standard shipping charge).
  * Return a `new Shipment` initialized with that calculated cost and the tracking string: `
  * "Shipped via " + order.getShippingMethod()`.

#### 6. `ExpressFulfillment.java` (Inherits from `FulfillmentService`)
* **Polymorphic Method Override:**
  * Override `processOrder(Order order)`.
  * Calculate total cost as: `order.getItem().getPrice() + 25.00` (adds a $25 express processing surcharge).
  * Return a `new Shipment` initialized with that calculated cost and the tracking string: `"URGENT: Shipped via " + order.getShippingMethod()`.

---

### 🚦 Root Driver: `com.shop`

#### 7. `Main.java`
* Initialize items, orders, and a fulfillment engine to visually confirm everything integrates nicely before clicking the test runner!
