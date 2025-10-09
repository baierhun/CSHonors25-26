# JavaFX Layout Managers

JavaFX provides several **layout panes** to arrange nodes in different ways.

---

## 🔹 StackPane
- Layers children **on top of each other** (centered by default).
- Best for overlays, backgrounds, and stacking content.

---

## 🔹 HBox
- Lays out children **horizontally** in a single row (left → right).
- Options: spacing, alignment, and padding.
- **Example use**: toolbar with buttons.

---

## 🔹 VBox
- Lays out children **vertically** in a single column (top → bottom).
- **Example use**: sidebar menu.

---

## 🔹 BorderPane
- Divides the window into **five regions**:
    - `top`, `bottom`, `left`, `right`, `center`
- **Example use**: dashboards or apps with header, footer, and sidebars.

---

## 🔹 GridPane
- Arranges children in a **grid of rows and columns**.
- **Example use**: forms, calculators, spreadsheet-like UIs.

---

## 🔹 FlowPane
- Places children in a row (or column).
- When there’s no more space, it **wraps to the next line** (like text wrapping).
- **Example use**: icons, thumbnails, or tags.

---

## 🔹 TilePane
- Similar to `FlowPane`, but children are resized to fit equal “tiles.”
- **Example use**: photo gallery or uniform buttons.

---

## 🔹 AnchorPane
- Lets you **anchor children** to the `top`, `bottom`, `left`, or `right` edges.
- **Example use**: pin a button to the bottom-right corner.

---

## 🔹 Pane
- Basic container.
- Doesn’t auto-position — children keep their `x, y` coordinates.
- **Example use**: custom graphics or animations.

---

## 🔹 Group
- Similar to `Pane`, but treats all children as a **single group**.
- Resizing the window doesn’t reposition them.
- **Example use**: custom drawing.

---

## ✅ Summary
- **Simple overlay** → `StackPane`
- **Horizontal/Vertical row** → `HBox` / `VBox`
- **Whole window with sections** → `BorderPane`
- **Spreadsheet-style** → `GridPane`
- **Wrap-around layout** → `FlowPane`
- **Uniform tiles** → `TilePane`
- **Anchored elements** → `AnchorPane`
- **Custom/manual positioning** → `Pane` / `Group`  
