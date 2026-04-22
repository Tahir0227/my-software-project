package com.service;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.entity.*;
import com.util.DbUtil;

/**
 * Comprehensive Database Service for Service Management System
 * Handles all CRUD operations and business logic
 */
public class DatabaseService {
    
    // ==================== CUSTOMER OPERATIONS ====================
    
    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer ORDER BY customer_id";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setUserName(rs.getString("user_name"));
                customer.setPassword(rs.getString("password"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNo(rs.getString("phone_no"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching customers: " + e.getMessage());
            e.printStackTrace();
        }
        return customers;
    }
    
    public static boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customer (user_name, password, name, address, city, email, phone_no) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, customer.getUserName());
            ps.setString(2, customer.getPassword());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getCity());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPhoneNo());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding customer: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET user_name=?, password=?, name=?, address=?, city=?, email=?, phone_no=? WHERE customer_id=?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, customer.getUserName());
            ps.setString(2, customer.getPassword());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getCity());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPhoneNo());
            ps.setInt(8, customer.getId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating customer: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteCustomer(int customerId) {
        String sql = "DELETE FROM customer WHERE customer_id=?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, customerId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting customer: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // ==================== TECHNICIAN OPERATIONS ====================
    
    public static List<Technician> getAllTechnicians() {
        List<Technician> technicians = new ArrayList<>();
        String sql = "SELECT * FROM technician ORDER BY technician_id";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Technician technician = new Technician();
                technician.setId(rs.getInt("technician_id"));
                technician.setUserName(rs.getString("user_name"));
                technician.setPassword(rs.getString("password"));
                technician.setName(rs.getString("name"));
                technician.setPhoneNo(rs.getString("phone_no"));
                technician.setSkill(rs.getString("skill"));
                technician.setAvailable(rs.getBoolean("availability"));
                technicians.add(technician);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching technicians: " + e.getMessage());
            e.printStackTrace();
        }
        return technicians;
    }
    
    public static boolean addTechnician(Technician technician) {
        String sql = "INSERT INTO technician (user_name, password, name, phone_no, skill, availability) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, technician.getUserName());
            ps.setString(2, technician.getPassword());
            ps.setString(3, technician.getName());
            ps.setString(4, technician.getPhoneNo());
            ps.setString(5, technician.getSkill());
            ps.setBoolean(6, technician.getisAvailable());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding technician: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateTechnician(Technician technician) {
        String sql = "UPDATE technician SET user_name=?, password=?, name=?, phone_no=?, skill=?, availability=? WHERE technician_id=?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, technician.getUserName());
            ps.setString(2, technician.getPassword());
            ps.setString(3, technician.getName());
            ps.setString(4, technician.getPhoneNo());
            ps.setString(5, technician.getSkill());
            ps.setBoolean(6, technician.getisAvailable());
            ps.setInt(7, technician.getId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating technician: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteTechnician(int technicianId) {
        String sql = "DELETE FROM technician WHERE technician_id=?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, technicianId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting technician: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // ==================== PARTS OPERATIONS ====================
    
    public static List<Parts> getAllParts() {
        List<Parts> parts = new ArrayList<>();
        String sql = "SELECT * FROM parts ORDER BY part_no";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Parts part = new Parts();
                part.setPartNo(rs.getInt("part_no"));
                part.setPartName(rs.getString("part_name"));
                part.setQuantity(rs.getInt("quantity"));
                part.setPrice(rs.getDouble("price"));
                parts.add(part);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching parts: " + e.getMessage());
            e.printStackTrace();
        }
        return parts;
    }
    
    public static boolean addPart(Parts part) {
        String sql = "INSERT INTO parts (part_no, part_name, quantity, price) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, part.getPartNo());
            ps.setString(2, part.getPartName());
            ps.setInt(3, part.getQuantity());
            ps.setDouble(4, part.getPrice());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding part: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updatePart(Parts part) {
        String sql = "UPDATE parts SET part_name=?, quantity=?, price=? WHERE part_no=?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, part.getPartName());
            ps.setInt(2, part.getQuantity());
            ps.setDouble(3, part.getPrice());
            ps.setInt(4, part.getPartNo());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating part: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deletePart(int partNo) {
        String sql = "DELETE FROM parts WHERE part_no=?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, partNo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting part: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<Parts> getLowStockParts(int threshold) {
        List<Parts> lowStockParts = new ArrayList<>();
        String sql = "SELECT * FROM parts WHERE quantity <= ? ORDER BY quantity ASC";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, threshold);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Parts part = new Parts();
                part.setPartNo(rs.getInt("part_no"));
                part.setPartName(rs.getString("part_name"));
                part.setQuantity(rs.getInt("quantity"));
                part.setPrice(rs.getDouble("price"));
                lowStockParts.add(part);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching low stock parts: " + e.getMessage());
            e.printStackTrace();
        }
        return lowStockParts;
    }
    
    // ==================== SERVICE REQUEST OPERATIONS ====================
    
    public static List<Service_Request> getAllServiceRequests() {
        List<Service_Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM service_request ORDER BY request_id DESC";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Service_Request request = new Service_Request();
                request.setRequestId(rs.getInt("request_id"));
                request.setCustomerID(rs.getInt("customer_id"));
                request.setIssueDescription(rs.getString("issue"));
                request.setRequestDate(rs.getDate("request_date"));
                request.setStatus(rs.getString("status"));
                requests.add(request);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching service requests: " + e.getMessage());
            e.printStackTrace();
        }
        return requests;
    }
    
    public static List<Service_Request> getCustomerRequests(int customerId) {
        List<Service_Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM service_request WHERE customer_id = ? ORDER BY request_id DESC";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Service_Request request = new Service_Request();
                request.setRequestId(rs.getInt("request_id"));
                request.setCustomerID(rs.getInt("customer_id"));
                request.setIssueDescription(rs.getString("issue"));
                request.setRequestDate(rs.getDate("request_date"));
                request.setStatus(rs.getString("status"));
                requests.add(request);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching customer requests: " + e.getMessage());
            e.printStackTrace();
        }
        return requests;
    }
    
    public static boolean createServiceRequest(Service_Request request) {
        String sql = "INSERT INTO service_request (customer_id, issue, request_date, status) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, request.getCustomerID());
            ps.setString(2, request.getIssueDescription());
            ps.setString(3, new java.sql.Date(System.currentTimeMillis()).toString());
            ps.setString(4, "Pending");
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error creating service request: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateServiceRequestStatus(int requestId, String status) {
        String sql = "UPDATE service_request SET status = ? WHERE request_id = ?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, status);
            ps.setInt(2, requestId);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating service request status: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // ==================== SERVICE MANAGEMENT OPERATIONS ====================
    
    public static List<Service_Manage> getAllServiceManagements() {
        List<Service_Manage> managements = new ArrayList<>();
        String sql = "SELECT * FROM service_manage ORDER BY request_id DESC";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Service_Manage management = new Service_Manage();
                management.getSr().setRequestId(rs.getInt("request_id"));
                management.getSr().setCustomerID(rs.getInt("customer_id"));
                management.getSr().setIssueDescription(rs.getString("issue"));
                management.setTechnicianID(rs.getInt("technician_id"));
                management.getSr().setRequestDate(rs.getDate("request_date"));
                management.setCompleteDate(rs.getDate("complete_date"));
                management.getSr().setStatus(rs.getString("status"));
                managements.add(management);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching service managements: " + e.getMessage());
            e.printStackTrace();
        }
        return managements;
    }
    
    public static List<Service_Manage> getTechnicianJobs(int technicianId) {
        List<Service_Manage> jobs = new ArrayList<>();
        String sql = "SELECT * FROM service_manage WHERE technician_id = ? ORDER BY request_id DESC";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, technicianId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Service_Manage management = new Service_Manage();
                management.getSr().setRequestId(rs.getInt("request_id"));
                management.getSr().setCustomerID(rs.getInt("customer_id"));
                management.getSr().setIssueDescription(rs.getString("issue"));
                management.setTechnicianID(rs.getInt("technician_id"));
                management.getSr().setRequestDate(rs.getDate("request_date"));
                management.setCompleteDate(rs.getDate("complete_date"));
                management.getSr().setStatus(rs.getString("status"));
                jobs.add(management);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching technician jobs: " + e.getMessage());
            e.printStackTrace();
        }
        return jobs;
    }
    
    public static boolean assignTechnicianToRequest(int requestId, int technicianId) {
        Connection conn = null;
        try {
            conn = DbUtil.getConnection();
            conn.setAutoCommit(false);
            
            // Get request details
            String getRequestSql = "SELECT * FROM service_request WHERE request_id = ?";
            Service_Request request = null;
            try (PreparedStatement ps = conn.prepareStatement(getRequestSql)) {
                ps.setInt(1, requestId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    request = new Service_Request();
                    request.setRequestId(rs.getInt("request_id"));
                    request.setCustomerID(rs.getInt("customer_id"));
                    request.setIssueDescription(rs.getString("issue"));
                    request.setRequestDate(rs.getDate("request_date"));
                    request.setStatus("In Progress");
                }
            }
            
            if (request == null) {
                return false;
            }
            
            // Insert into service_manage
            String insertSql = "INSERT INTO service_manage (request_id, customer_id, issue, technician_id, request_date, complete_date, status) VALUES (?, ?, ?, ?, ?, NULL, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                ps.setInt(1, request.getRequestId());
                ps.setInt(2, request.getCustomerID());
                ps.setString(3, request.getIssueDescription());
                ps.setInt(4, technicianId);
                ps.setString(5, request.getRequestDate());
                ps.setString(6, "In Progress");
                ps.executeUpdate();
            }
            
            // Update technician availability
            String updateTechSql = "UPDATE technician SET availability = false WHERE technician_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(updateTechSql)) {
                ps.setInt(1, technicianId);
                ps.executeUpdate();
            }
            
            // Delete from service_request
            String deleteSql = "DELETE FROM service_request WHERE request_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(deleteSql)) {
                ps.setInt(1, requestId);
                ps.executeUpdate();
            }
            
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.err.println("Error assigning technician to request: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // ==================== INVOICE OPERATIONS ====================
    
    public static List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        String sql = "SELECT * FROM invoice ORDER BY invoice_id DESC";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceid(rs.getInt("invoice_id"));
                invoice.setPartsTotalAmt(rs.getDouble("parts_total_amt"));
                invoice.setTecnicianCost(rs.getDouble("technician_cost"));
                invoice.setTotalAmt(rs.getDouble("total_amt"));
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching invoices: " + e.getMessage());
            e.printStackTrace();
        }
        return invoices;
    }
    
    public static boolean generateInvoice(int requestId) {
        String sql = "INSERT INTO invoice (request_id, parts_total_amt, technician_cost, total_amt) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Calculate parts total
            double partsTotal = calculatePartsTotal(requestId);
            double technicianCost = 500.00; // Fixed technician cost
            double totalAmount = partsTotal + technicianCost;
            
            ps.setInt(1, requestId);
            ps.setDouble(2, partsTotal);
            ps.setDouble(3, technicianCost);
            ps.setDouble(4, totalAmount);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error generating invoice: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    private static double calculatePartsTotal(int requestId) {
        String sql = "SELECT SUM(p.price) as total FROM parts_used pu JOIN parts p ON pu.part_no = p.part_no WHERE pu.request_id = ?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, requestId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.err.println("Error calculating parts total: " + e.getMessage());
            e.printStackTrace();
        }
        return 0.0;
    }
    
    // ==================== STATISTICS AND ANALYTICS ====================
    
    public static Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        
        try (Connection conn = DbUtil.getConnection()) {
            // Total customers
            String customerSql = "SELECT COUNT(*) as count FROM customer";
            try (PreparedStatement ps = conn.prepareStatement(customerSql);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    stats.put("totalCustomers", rs.getInt("count"));
                }
            }
            
            // Active technicians
            String techSql = "SELECT COUNT(*) as count FROM technician WHERE availability = true";
            try (PreparedStatement ps = conn.prepareStatement(techSql);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    stats.put("activeTechnicians", rs.getInt("count"));
                }
            }
            
            // Pending requests
            String pendingSql = "SELECT COUNT(*) as count FROM service_request WHERE status = 'Pending'";
            try (PreparedStatement ps = conn.prepareStatement(pendingSql);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    stats.put("pendingRequests", rs.getInt("count"));
                }
            }
            
            // Completed services
            String completedSql = "SELECT COUNT(*) as count FROM service_manage WHERE status = 'completed'";
            try (PreparedStatement ps = conn.prepareStatement(completedSql);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    stats.put("completedServices", rs.getInt("count"));
                }
            }
            
            // Total revenue
            String revenueSql = "SELECT SUM(total_amt) as total FROM invoice";
            try (PreparedStatement ps = conn.prepareStatement(revenueSql);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    stats.put("totalRevenue", rs.getDouble("total"));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error fetching dashboard stats: " + e.getMessage());
            e.printStackTrace();
        }
        
        return stats;
    }
    
    // ==================== AUTHENTICATION ====================
    
    public static Map<String, Object> authenticateUser(String username, String password, String role) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", false);
        
        try (Connection conn = DbUtil.getConnection()) {
            String sql = "";
            String idColumn = "";
            
            switch (role.toLowerCase()) {
                case "admin":
                    sql = "SELECT admin_id FROM admin WHERE user_name = ? AND password = ?";
                    idColumn = "admin_id";
                    break;
                case "technician":
                    sql = "SELECT technician_id FROM technician WHERE user_name = ? AND password = ?";
                    idColumn = "technician_id";
                    break;
                case "customer":
                    sql = "SELECT customer_id FROM customer WHERE user_name = ? AND password = ?";
                    idColumn = "customer_id";
                    break;
                default:
                    return result;
            }
            
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    result.put("success", true);
                    result.put("role", role.toLowerCase());
                    result.put("userId", rs.getInt(idColumn));
                    result.put("username", username);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error authenticating user: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }
}

