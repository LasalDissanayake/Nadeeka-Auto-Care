import { Page } from '@playwright/test';

export async function loginPageNavigation(page:Page) {

    page.goto('http://localhost:5173/cLogin');
    
}

export async function login(page: Page, username: string, password: string) {
  const un = page.locator('[id = "username"]');
  const pw = page.locator('[name = "password"]');
  const sub = page.locator('[name = "submit"]');

  await un.fill(username);
  await pw.fill(password);
  await sub.click();
}

export async function creatInventoryNavigation(page: Page) {

    await login (page, "inventory", "inventory123");
    const createInventoryButton = page.locator('[name = "createInventoryButton"]');
    await createInventoryButton.click();
    
}
