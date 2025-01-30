import { test, expect, Page } from '@playwright/test';
import { login } from './correctLogin';

test('form navigation', async ({ page }) => {
    // Navigate to the Inventory Dashboard
    await page.goto('http://localhost:5173/cLogin');
    await login(page, "inventory", "inventory123");

    // Navigate to the Create Inventory form
    const createInventoryButton = page.locator('[name="createInventoryButton"]');
    await createInventoryButton.click();
    await page.waitForTimeout(3000);
});

test('Validate the Name field', async ({ page }) => {
    // Locate the name input field
    const nameField = page.locator('[name="nameField"]');

    // Fill the name field with "Tool"
    await nameField.fill("Tool");
});
